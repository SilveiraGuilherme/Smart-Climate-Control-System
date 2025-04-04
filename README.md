# Smart Climate Control System
 A simulated smart home system using Java + gRPC with 3 main services

<a name="readme-top"></a>

<!-- PROJECT LOGO -->

<div align="center">

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br />
<br />

  <h3 align="center">Smart Climate Control System</h3>

  <p align="center">
    A Distributed Systems project that simulates smart climate control in a home environment using gRPC microservices.
    <br />
    <a href="https://github.com/SilveiraGuilherme/SmartClimateControlSystem">View Repository</a>
    ·
    <a href="https://github.com/SilveiraGuilherme/SmartClimateControlSystem/issues/new">Report Bug</a>
  </p>
</div>

<br/>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#requirements">Requirements</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#links">Links</a></li>
  </ol>
</details>

<br/>

## About The Project

This is a simulated **Smart Home Climate Control System** developed for the Distributed Systems module of the Higher Diploma in Computing at NCI. It uses **gRPC** in Java to simulate interaction between smart home devices/services.

The system consists of three core services:

- **Thermostat Service** – Manages heating and cooling
- **Humidity Controller Service** – Adjusts indoor humidity
- **Air Quality Monitor Service** – Tracks air quality and emits alerts

All four gRPC invocation styles are implemented: Unary, Server Streaming, Client Streaming, and Bi-directional Streaming.

### Built With

- <strong>Java</strong> (NetBeans)
- <strong>gRPC</strong>
- <strong>Maven</strong>
- <strong>Protocol Buffers</strong>
- <strong>Swing GUI</strong> (for simulation)

## Getting Started

To run this project locally, follow the steps below.

### Requirements

- Java 11+
- NetBeans or IntelliJ (with Maven support)
- Maven

### Installation

1. Clone the repo
   ```bash
   git clone https://github.com/SilveiraGuilherme/SmartClimateControlSystem.git
