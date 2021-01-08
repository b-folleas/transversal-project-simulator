package simulator.projet.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomService {



    public int randInt(int high) {
        java.util.Random r = new java.util.Random();
        int low = 1;
        high += 1;
        return  r.nextInt(high-low) + low;
    }


    public int randIndex(List<?> list) {
        java.util.Random r = new java.util.Random();
        return r.nextInt(list.size());
    }
}
