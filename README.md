<H4> comando para gerar o conteiner docker para RaabbitMQ:<H4>  docker run -it  --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management 

![image](https://github.com/user-attachments/assets/854732f0-ea48-4f44-938a-24de4a425001)
<H4></H4> 
<H4>Comando para gerar o conteiner docker para o Keycloak</H4>
docker run -p 8081:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.0.0 start-dev

