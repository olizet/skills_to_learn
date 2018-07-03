package pl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.app.entity.Skill;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skill,Long> {
}
