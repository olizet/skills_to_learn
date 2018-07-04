package pl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.app.entity.Skill;
import pl.app.repository.SkillsRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsRepository skillsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Skill> showSkills() {
        List<Skill> skills = skillsRepository.findAll();
        return skills;
    }
    @RequestMapping(value="/", method = RequestMethod.POST)
    public void saveSkill(@RequestBody Skill skill){
        skillsRepository.save(skill);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Skill getSkillbyId(@PathVariable Long id) {
        Skill skill = skillsRepository.findSkillById(id);
        return skill;
    }
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteSkill(@PathVariable Long id){
    Skill skill = skillsRepository.findSkillById(id);
    skillsRepository.delete(skill);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public void editSkill(@RequestBody Skill skill,@PathVariable Long id){
        skill.setId(id);
        skillsRepository.save(skill);
    }
}
