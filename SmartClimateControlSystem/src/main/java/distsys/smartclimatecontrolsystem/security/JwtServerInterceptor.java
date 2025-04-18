package distsys.smartclimatecontrolsystem.security;

import io.grpc.*;
import io.jsonwebtoken.*;
import java.util.logging.Logger;
import static distsys.smartclimatecontrolsystem.security.JwtUtil.SECRET_KEY;

public class JwtServerInterceptor implements ServerInterceptor {

    private static final Logger logger = Logger.getLogger(JwtServerInterceptor.class.getName());
    private static final Metadata.Key<String> AUTHORIZATION_KEY =
        Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        String token = headers.get(AUTHORIZATION_KEY);

        if (token == null || token.isEmpty()) {
            call.close(Status.UNAUTHENTICATED.withDescription("Authorization token is missing"), headers);
            return new ServerCall.Listener() {};
        }

        try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            logger.info("JWT verified successfully.");
        } catch (JwtException e) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid JWT token: " + e.getMessage()), headers);
            return new ServerCall.Listener<ReqT>() {};
        }

        return next.startCall(call, headers);
    }
}