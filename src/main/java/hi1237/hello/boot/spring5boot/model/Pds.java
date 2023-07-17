package hi1237.hello.boot.spring5boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Pds {

    private String pno;
    private String title;
    private String userid;
    private String regdate;
    private String thumbs;
    private String views;
    private String contents;
    private String ipaddr;

    private PdsAttach pa;
}

