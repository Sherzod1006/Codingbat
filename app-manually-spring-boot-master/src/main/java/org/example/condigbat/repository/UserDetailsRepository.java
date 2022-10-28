package org.example.condigbat.repository;

import org.example.condigbat.entity.UserDetails;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedEntityGraph;
import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

   @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//           value = "user_details_entity_graph",
           attributePaths = "addresses"
   )
   List<UserDetails> findByNameContaining(String text);
}