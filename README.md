# OSGiCassandra
The module offers Cassandra java library in the OSGi environment using CDI. 
The Maven project consists of two modules namely agenda-api and agenda-web.
The agenda-api provides the backend connectivity to Cassandra through the java library.
In addition, the module exports the package with the interface.
The specification used for CDI is based on 1.2 release.

The agenda-web module includes a servlet and injects the dependency by importing the interface from agenda-api.
