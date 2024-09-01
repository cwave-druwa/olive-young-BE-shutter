package olive.young.shutter.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shutter")
//@Transactional
public class Controller {

    @GetMapping
    public List<ShutterDTO> test() {
        List<ShutterDTO> shutterList = new ArrayList<>();
        shutterList.add(new ShutterDTO(
                1L,
                "imageURL",
                "유저 닉네임",
                "삐끼삐끼 챌린지",
                false,
                5
        ));

        return shutterList;
    }

}
