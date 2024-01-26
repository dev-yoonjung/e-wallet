package vvithnne.ewallet.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import vvithnne.ewallet.membership.adapter.in.web.dto.request.RegisterMembershipRequest;
import vvithnne.ewallet.membership.adapter.in.web.dto.response.MembershipResponse;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private static final String MEMBERSHIP_URI = "/membership";

    private static final RegisterMembershipRequest 하이브_요청 = new RegisterMembershipRequest(
            "(주)하이브",
            "서울특별시 용산구 한강대로 42",
            "hitmanb@hybecorp.com",
            true
    );

    private static final MembershipResponse 하이브_응답 = new MembershipResponse(
            1L,
            하이브_요청.name(),
            하이브_요청.address(),
            하이브_요청.email(),
            true,
            하이브_요청.isCorp()
    );

    @Test
    void registerMembership() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post(MEMBERSHIP_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(하이브_요청))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(하이브_응답)));
    }
}