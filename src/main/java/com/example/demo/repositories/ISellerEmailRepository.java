package com.example.demo.repositories;

import com.example.demo.models.BuyerEmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISellerEmailRepository extends JpaRepository<BuyerEmailModel, Long> {

}
