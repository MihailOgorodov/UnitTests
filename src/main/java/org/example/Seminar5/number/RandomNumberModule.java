package org.example.Seminar5.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {

    public List<Integer> generate(int length) {
        List<Integer> resLst = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            resLst.add(new Random().nextInt(100));
        }
        return resLst;
    }
}
