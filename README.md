# postgresql-passwordless-with-cert-verification
- Prepare AKS
- Prepare Flexi Postgresql with AAD integration enabled
- Prepare User Assigned Managed Identity
- Add the UAMI to the Postgresql and set correct permissions
- Create service account in the AKS and federate credentials from the UAMI to the AKS service account
- Edit UAMI and database related configuration in `./src/main/resources/application.yml`
- Build the application: `./mvnw package`
- Build the Docker image: `docker build -t <tag> .`
- Create a pod in the AKS with this image and previously mentioned service account