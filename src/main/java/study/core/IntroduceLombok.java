package study.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IntroduceLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        IntroduceLombok introduceLombok = new IntroduceLombok();
        introduceLombok.setName("Kim");

        System.out.println("introduceLombok = " + introduceLombok);
    }
}
