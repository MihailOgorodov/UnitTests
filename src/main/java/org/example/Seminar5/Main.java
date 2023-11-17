package org.example.Seminar5;

import org.example.Seminar5.number.MaxNumberModule;
import org.example.Seminar5.number.RandomNumberModule;

import java.util.List;

public class Main {

    public static void main(String[] args) {



        RandomNumberModule randModule = new RandomNumberModule();
        List<Integer> result = randModule.generate(6);

        MaxNumberModule maxValModule = new MaxNumberModule();
        Integer maxValue = maxValModule.findMax(result);

        System.out.println(result);
        System.out.println(maxValue);

    }

}