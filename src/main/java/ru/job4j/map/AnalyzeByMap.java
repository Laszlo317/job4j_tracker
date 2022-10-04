package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double average = 0;
        int subjCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                average += subject.score();
                subjCount++;
            }
        }
        average /= subjCount;
        return average;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int average = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subj : subjects) {
                average += subj.score();
            }
            average /= subjects.size();
            labels.add(new Label(pupil.name(), average));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> labels = new LinkedHashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject pupilSubj : pupil.subjects()) {
                    if (labels.containsKey(pupilSubj.name())) {
                        int sum = labels.get(pupilSubj.name()) + pupilSubj.score();
                        labels.put(pupilSubj.name(), sum);
                    } else {
                        labels.put(pupilSubj.name(), pupilSubj.score());
                    }
                }
            }

            List<Label> labelList = new ArrayList<>();
            for (String key : labels.keySet()) {
                labelList.add(new Label(key, labels.get(key) / pupils.size()));
            }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int average = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subj : subjects) {
                average += subj.score();
            }
            labels.add(new Label(pupil.name(), average));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> labels = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject pupilSubj : pupil.subjects()) {
                if (labels.containsKey(pupilSubj.name())) {
                    int sum = labels.get(pupilSubj.name()) + pupilSubj.score();
                    labels.put(pupilSubj.name(), sum);
                } else {
                    labels.put(pupilSubj.name(), pupilSubj.score());
                }
            }
        }

        List<Label> labelList = new ArrayList<>();
        for (String key : labels.keySet()) {
            labelList.add(new Label(key, labels.get(key)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}