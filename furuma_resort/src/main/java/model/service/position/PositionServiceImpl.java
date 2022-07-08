package model.service.position;

import model.bean.Position;
import model.repository.employee.position.PositionRepository;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepository();

    @Override
    public List<Position> getAll() {
        return positionRepository.getAllPosition();
    }
}
