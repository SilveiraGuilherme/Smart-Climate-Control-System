package distsys.smartclimatecontrolsystem.security;

import io.grpc.*;

import java.util.logging.Logger;

/**
 * Client-side interceptor that adds a JWT token to the metadata for each request.
 */
public class JwtClientInterceptor implements ClientInterceptor {

    private static final Logger logger = Logger.getLogger(JwtClientInterceptor.class.getName());
    private final String token;

    public JwtClientInterceptor(String token) {
        this.token = token;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next) {

        return new ForwardingClientCall.SimpleForwardingClientCall(next.newCall(method, callOptions)) {
            
            @Override
            public void start(Listener responseListener, Metadata headers) {
                // Inject the token into metadata
                Metadata.Key<String> authorizationKey =
                    Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

                headers.put(authorizationKey, token);
                logger.info("JWT token attached to request");
                super.start(responseListener, headers);
            }
        };
    }
}