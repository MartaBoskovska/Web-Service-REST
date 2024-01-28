package web.trivago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import web.trivago.models.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

}
