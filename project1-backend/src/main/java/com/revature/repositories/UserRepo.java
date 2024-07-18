package com.revature.repositories;

import com.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    public List<User> findByTokenId(String tokenId);

    public List<User> findByNameAndPassword(String name,String password);

    public List<User> findByTokenIdAndTokenPassword(String tokenId,String tokenPassword);

    public void deleteByName(String name);
}
