package com.example.demo.repositories;

import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuyerEmailRepository extends JpaRepository<BuyerEmailModel, Long> {

}
