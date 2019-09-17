package com.MentorOnDemand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MentorOnDemand.model.ProposalRequest;
import com.MentorOnDemand.model.Trainings;

public interface TrainingDao extends JpaRepository<Trainings, Long> {

}
