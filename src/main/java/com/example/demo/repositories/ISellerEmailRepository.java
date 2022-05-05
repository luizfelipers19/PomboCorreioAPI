package com.example.demo.repositories;

import com.example.demo.models.BuyerEmailModel;
import com.example.demo.models.SellerEmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISellerEmailRepository extends JpaRepository<SellerEmailModel, Long> {

}
