package com.unbreakable.unbreakable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercises_Calisthenics {

    @Id
    private int id;
    private String group;
    private String variation;
    private String movement;
    private String target;
    private int level;
    private int level_breakthrough;
    private int skill_static;
    private int skill_dynamic;
    private int repetition;
    private int time;
    private int floor;
    private int high_bar;
    private int medium_bar;
    private int low_bar;
    private int parallel_bars;
    private int parallettes;
    private int swedish_ladder;
    private int vertical_bar;
    private int wall;
    private int rings;
    private int support;
    private String description;



    public Exercises_Calisthenics(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel_breakthrough() {
        return level_breakthrough;
    }

    public void setLevel_breakthrough(int level_breakthrough) {
        this.level_breakthrough = level_breakthrough;
    }

    public int getSkill_static() {
        return skill_static;
    }

    public void setSkill_static(int skill_static) {
        this.skill_static = skill_static;
    }

    public int getSkill_dynamic() {
        return skill_dynamic;
    }

    public void setSkill_dynamic(int skill_dynamic) {
        this.skill_dynamic = skill_dynamic;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getHigh_bar() {
        return high_bar;
    }

    public void setHigh_bar(int high_bar) {
        this.high_bar = high_bar;
    }

    public int getMedium_bar() {
        return medium_bar;
    }

    public void setMedium_bar(int medium_bar) {
        this.medium_bar = medium_bar;
    }

    public int getLow_bar() {
        return low_bar;
    }

    public void setLow_bar(int low_bar) {
        this.low_bar = low_bar;
    }

    public int getParallel_bars() {
        return parallel_bars;
    }

    public void setParallel_bars(int parallel_bars) {
        this.parallel_bars = parallel_bars;
    }

    public int getParallettes() {
        return parallettes;
    }

    public void setParallettes(int parallettes) {
        this.parallettes = parallettes;
    }

    public int getSwedish_ladder() {
        return swedish_ladder;
    }

    public void setSwedish_ladder(int swedish_ladder) {
        this.swedish_ladder = swedish_ladder;
    }

    public int getVertical_bar() {
        return vertical_bar;
    }

    public void setVertical_bar(int vertical_bar) {
        this.vertical_bar = vertical_bar;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public int getRings() {
        return rings;
    }

    public void setRings(int rings) {
        this.rings = rings;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
