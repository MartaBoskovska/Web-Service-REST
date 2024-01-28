package web.trivago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import web.trivago.models.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Integer> {

}
