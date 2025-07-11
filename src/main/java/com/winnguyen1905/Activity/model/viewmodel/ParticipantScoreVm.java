package com.winnguyen1905.activity.model.viewmodel;

import com.winnguyen1905.activity.common.constant.ParticipationRole;
import com.winnguyen1905.activity.model.dto.AbstractModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantScoreVm implements AbstractModel {
    private Long participantId;
    private String participantName;
    private String feedbackDescription;
    private ParticipationRole role;
    private Double score;
    private Double feedbackRating;
}
