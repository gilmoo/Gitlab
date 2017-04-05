# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM payara/server-full:162
ENV PAYARA_ARCHIVE payara41
ENV DOMAIN_NAME domain1
ENV INSTALL_DIR /opt
ENV PAYARA_HOME ${INSTALL_DIR}/payara41/glassfish
ENV EXEC ${PAYARA_HOME}/bin
ENV DEPLOYMENT_DIR ${PAYARA_HOME}/domains/${DOMAIN_NAME}/autodeploy/
ENV ARTIFACT Kwetter-1.0-SNAPSHOT
ENTRYPOINT bin/asadmin start-domain --verbose ${DOMAIN_NAME}
EXPOSE 4848 8009 8080 8181
#WORKDIR /opt/payara41/glassfish/bin
#COPY ./target/coffee.war /opt/payara41/glassfish/domains/domain1/autodeploy
COPY ./target/${ARTIFACT}.war ${DEPLOYMENT_DIR}

