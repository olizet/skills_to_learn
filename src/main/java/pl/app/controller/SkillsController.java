package pl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.app.entity.Skill;
import pl.app.repository.SkillsRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/skills", method = RequestMethod.GET)
public class SkillsController {
    @Autowired
    SkillsRepository skillsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Skill> showSkills() {
        List<Skill> skills = skillsRepository.findAll();
        return skills;
    }
}
