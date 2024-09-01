package olive.young.shutter.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = Controller.class)
class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Controller controller;

    @Test
    @DisplayName("셔터 컨트롤러에서 리스트를 반환한다.")
    public void testShutterList() throws Exception {
        // 샘플 데이터 생성
        ShutterDTO shutterDTO = new ShutterDTO(
                1L,
                "imageURL",
                "유저 닉네임",
                "삐끼삐끼 챌린지",
                false,
                5
        );

        // Mock 데이터를 반환하도록 설정
        given(controller.test()).willReturn(List.of(shutterDTO));

        // MockMvc를 통해 /shutter 엔드포인트로 GET 요청 수행
        mockMvc.perform(get("/shutter"))
                .andExpect(status().isOk())  // HTTP 상태 코드가 200인지 확인
                .andExpect(jsonPath("$[0].id").value(shutterDTO.id()))  // 첫 번째 아이템의 id가 1인지 확인
                .andExpect(jsonPath("$[0].imageURL").value(shutterDTO.imageURL()))  // 첫 번째 아이템의 imageURL이 올바른지 확인
                .andExpect(jsonPath("$[0].userName").value(shutterDTO.userName()))  // 첫 번째 아이템의 userName이 올바른지 확인
                .andExpect(jsonPath("$[0].content").value(shutterDTO.content()))  // 첫 번째 아이템의 content가 올바른지 확인
                .andExpect(jsonPath("$[0].isLiked").value(shutterDTO.isLiked()))  // 첫 번째 아이템의 isLiked가 false인지 확인
                .andExpect(jsonPath("$[0].likedCount").value(shutterDTO.likedCount()));  // 첫 번째 아이템의 likedCount가 5인지 확인
    }
}