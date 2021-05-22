package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.repository.PerformanceRepository;

@Service
public class PerformanceService {

    @Autowired
    public final PerformanceRepository performanceRepository;


    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }
}
