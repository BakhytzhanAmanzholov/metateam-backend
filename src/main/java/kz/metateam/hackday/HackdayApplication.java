package kz.metateam.hackday;

import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.models.test.Answer;
import kz.metateam.hackday.models.test.Question;
import kz.metateam.hackday.models.test.Type;
import kz.metateam.hackday.service.AnswerService;
import kz.metateam.hackday.service.LessonService;
import kz.metateam.hackday.service.QuestionService;
import kz.metateam.hackday.service.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
public class HackdayApplication {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(HackdayApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TypeService typeService, QuestionService questionService, AnswerService answerService,
            LessonService lessonService) {
        return args -> {
            Type realistic = typeService.save(new Type("Реалистический тип",
                    "Примеры профессий: Механик, электрик, инженер, фермер, зоотехник, геолог, гравер, агроном, садовод, автослесарь, шофер, пилот, полицейский, охранник (телохранитель), сварщик, стоматолог."));
            Type intelligent = typeService.save(new Type("Интеллектуальный тип",
                    "Примеры профессий: Физик, астроном, лингвист, программист, микробиолог, архитектор, экономист (аудитор, аналитик), фармацевт, искусствовед, историк, этнограф, археолог."));
            Type artistic = typeService.save(new Type("Артистичный тип",
                    "Примеры профессий: Музыкант, художник, визажист, фотограф, актер, режиссер, дизайнер."));
            Type social = typeService.save(new Type("Социальный тип",
                    "Примеры профессий: Врач, педагог, психолог, экскурсовод, журналист, менеджер по продажам, ди-джей, телеведущий"));
            Type enterprising = typeService.save(new Type("Предприимчивый тип",
                    "Примеры профессий: Бизнесмен, маркетолог, менеджер, директор, заведующий, журналист, репортер, дипломат, юрист, политик, менеджер по продажам, биржевой брокер."));
            Type conventional = typeService.save(new Type("Традиционный тип",
                    "Примеры профессий: бухгалтер, финансист, экономист, канцелярский служащий, библиотекарь, контролер, химик-технолог, чертежник, корректор, логист, товаровед."));

            Answer answer1 = answerService.save(new Answer("инженер-техник", realistic));
            Answer answer2 = answerService.save(new Answer("вязальщик", realistic));
            Answer answer3 = answerService.save(new Answer("повар", realistic));
            Answer answer4 = answerService.save(new Answer("фотограф", realistic));
            Answer answer5 = answerService.save(new Answer("чертежник", realistic));
            Answer answer6 = answerService.save(new Answer("философ", intelligent));
            Answer answer7 = answerService.save(new Answer("ученый-химик", intelligent));
            Answer answer8 = answerService.save(new Answer("редактор научного журнала", intelligent));
            Answer answer9 = answerService.save(new Answer("лингвист", intelligent));
            Answer answer10 = answerService.save(new Answer("педиатр", social));
            Answer answer11 = answerService.save(new Answer("организатор воспитательной работы", social));
            Answer answer12 = answerService.save(new Answer("спортивный врач", social));
            Answer answer13 = answerService.save(new Answer("нотариус", conventional));
            Answer answer14 = answerService.save(new Answer("перфоратор", conventional));
            Answer answer15 = answerService.save(new Answer("политический деятель", enterprising));
            Answer answer16 = answerService.save(new Answer("садовник", realistic));
            Answer answer17 = answerService.save(new Answer("водитель", realistic));
            Answer answer18 = answerService.save(new Answer("инженер-электрик", realistic));
            Answer answer19 = answerService.save(new Answer("маляр", realistic));
            Answer answer20 = answerService.save(new Answer("биолог", intelligent));
            Answer answer21 = answerService.save(new Answer("телеоператор", realistic));
            Answer answer22 = answerService.save(new Answer("гидролог", intelligent));
            Answer answer23 = answerService.save(new Answer("зоолог", intelligent));
            Answer answer24 = answerService.save(new Answer("математик", intelligent));
            Answer answer25 = answerService.save(new Answer("работник ИДН", social));
            Answer answer26 = answerService.save(new Answer("учитель", social));
            Answer answer27 = answerService.save(new Answer("воспитатель", social));
            Answer answer28 = answerService.save(new Answer("экономист", conventional));
            Answer answer29 = answerService.save(new Answer("корректор", conventional));
            Answer answer30 = answerService.save(new Answer("завхоз", enterprising));
            Answer answer31 = answerService.save(new Answer("радиоинженер", realistic));
            Answer answer32 = answerService.save(new Answer("водопроводчик", realistic));
            Answer answer33 = answerService.save(new Answer("агроном", realistic));
            Answer answer34 = answerService.save(new Answer("закройщик-модельер", realistic));
            Answer answer35 = answerService.save(new Answer("археолог", intelligent));
            Answer answer36 = answerService.save(new Answer("работник музея", intelligent));
            Answer answer37 = answerService.save(new Answer("ученый", intelligent));
            Answer answer38 = answerService.save(new Answer("логопед", social));
            Answer answer39 = answerService.save(new Answer("врач", social));
            Answer answer40 = answerService.save(new Answer("главный бухгалтер", conventional));
            Answer answer41 = answerService.save(new Answer("поэт", artistic));
            Answer answer42 = answerService.save(new Answer("архивариус", conventional));

            Answer answer1B = answerService.save(new Answer("инженер-контролер", intelligent));
            Answer answer2B = answerService.save(new Answer("санитарный врач", social));
            Answer answer3B = answerService.save(new Answer("наборщик", conventional));
            Answer answer4B = answerService.save(new Answer("зав. магазином", enterprising));
            Answer answer5B = answerService.save(new Answer("дизайнер", artistic));
            Answer answer6B = answerService.save(new Answer("психиатр", social));
            Answer answer7B = answerService.save(new Answer("бухгалтер", conventional));
            Answer answer8B = answerService.save(new Answer("адвокат", enterprising));
            Answer answer9B = answerService.save(new Answer("переводчик художественной литературы", artistic));
            Answer answer10B = answerService.save(new Answer("статистик", conventional));
            Answer answer11B = answerService.save(new Answer("председатель профсоюза", enterprising));
            Answer answer12B = answerService.save(new Answer("фельетонист", artistic));
            Answer answer13B = answerService.save(new Answer("снабженец", enterprising));
            Answer answer14B = answerService.save(new Answer("карикатурист", artistic));
            Answer answer15B = answerService.save(new Answer("писатель", artistic));
            Answer answer16B = answerService.save(new Answer("метеоролог", intelligent));
            Answer answer17B = answerService.save(new Answer("медсестра", social));
            Answer answer18B = answerService.save(new Answer("секретарь-машинистка", conventional));
            Answer answer19B = answerService.save(new Answer("художник по металлу", artistic));
            Answer answer20B = answerService.save(new Answer("главный врач", enterprising));
            Answer answer21B = answerService.save(new Answer("режиссер", artistic));
            Answer answer22B = answerService.save(new Answer("ревизор", conventional));
            Answer answer23B = answerService.save(new Answer("зоотехник", enterprising));
            Answer answer24B = answerService.save(new Answer("архитектор", artistic));
            Answer answer25B = answerService.save(new Answer("счетовод", conventional));
            Answer answer26B = answerService.save(new Answer("полицейский", social));
            Answer answer27B = answerService.save(new Answer("художник по керамике", artistic));
            Answer answer28B = answerService.save(new Answer("заведующий отделом", enterprising));
            Answer answer29B = answerService.save(new Answer("критик", artistic));
            Answer answer30B = answerService.save(new Answer("директор", artistic));
            Answer answer31B = answerService.save(new Answer("специалист по ядерной физике", intelligent));
            Answer answer32B = answerService.save(new Answer("наборщик", conventional));
            Answer answer33B = answerService.save(new Answer("председатель сельхозкооператива", enterprising));
            Answer answer34B = answerService.save(new Answer("декоратор", artistic));
            Answer answer35B = answerService.save(new Answer("эксперт", enterprising));
            Answer answer36B = answerService.save(new Answer("консультант", social));
            Answer answer37B = answerService.save(new Answer("актер", enterprising));
            Answer answer38B = answerService.save(new Answer("стенографист", conventional));
            Answer answer39B = answerService.save(new Answer("дипломат", enterprising));
            Answer answer40B = answerService.save(new Answer("директор", enterprising));
            Answer answer41B = answerService.save(new Answer("психолог", social));
            Answer answer42B = answerService.save(new Answer("скульптор", artistic));

            Question question1 = questionService.save(new Question(answer1, answer1B));
            Question question2 = questionService.save(new Question(answer2, answer2B));
            Question question3 = questionService.save(new Question(answer3, answer3B));
            Question question4 = questionService.save(new Question(answer4, answer4B));
            Question question5 = questionService.save(new Question(answer5, answer5B));
            Question question6 = questionService.save(new Question(answer6, answer6B));
            Question question7 = questionService.save(new Question(answer7, answer7B));
            Question question8 = questionService.save(new Question(answer8, answer8B));
            Question question9 = questionService.save(new Question(answer9, answer9B));
            Question question10 = questionService.save(new Question(answer10, answer10B));
            Question question11 = questionService.save(new Question(answer11, answer11B));
            Question question12 = questionService.save(new Question(answer12, answer12B));
            Question question13 = questionService.save(new Question(answer13, answer13B));
            Question question14 = questionService.save(new Question(answer14, answer14B));
            Question question15 = questionService.save(new Question(answer15, answer15B));
            Question question16 = questionService.save(new Question(answer16, answer16B));
            Question question17 = questionService.save(new Question(answer17, answer17B));
            Question question18 = questionService.save(new Question(answer18, answer18B));
            Question question19 = questionService.save(new Question(answer19, answer19B));
            Question question20 = questionService.save(new Question(answer20, answer20B));
            Question question21 = questionService.save(new Question(answer21, answer21B));
            Question question22 = questionService.save(new Question(answer22, answer22B));
            Question question23 = questionService.save(new Question(answer23, answer23B));
            Question question24 = questionService.save(new Question(answer24, answer24B));
            Question question25 = questionService.save(new Question(answer25, answer25B));
            Question question26 = questionService.save(new Question(answer26, answer26B));
            Question question27 = questionService.save(new Question(answer27, answer27B));
            Question question28 = questionService.save(new Question(answer28, answer28B));
            Question question29 = questionService.save(new Question(answer29, answer29B));
            Question question30 = questionService.save(new Question(answer30, answer30B));
            Question question31 = questionService.save(new Question(answer31, answer31B));
            Question question32 = questionService.save(new Question(answer32, answer32B));
            Question question33 = questionService.save(new Question(answer33, answer33B));
            Question question34 = questionService.save(new Question(answer34, answer34B));
            Question question35 = questionService.save(new Question(answer35, answer35B));
            Question question36 = questionService.save(new Question(answer36, answer36B));
            Question question37 = questionService.save(new Question(answer37, answer37B));
            Question question38 = questionService.save(new Question(answer38, answer38B));
            Question question39 = questionService.save(new Question(answer39, answer39B));
            Question question40 = questionService.save(new Question(answer40, answer40B));
            Question question41 = questionService.save(new Question(answer41, answer41B));
            Question question42 = questionService.save(new Question(answer42, answer42B));


            Lesson lesson = lessonService.save(new Lesson("Математика", ""));

//            realistic.getAnswerList().add(answer1);
//            realistic.getAnswerList().add(answer2);
//            realistic.getAnswerList().add(answer3);
//            realistic.getAnswerList().add(answer4);
//            realistic.getAnswerList().add(answer5);
//            realistic.getAnswerList().add(answer16);
//            realistic.getAnswerList().add(answer17);
//            realistic.getAnswerList().add(answer18);
//            realistic.getAnswerList().add(answer19);
//            realistic.getAnswerList().add(answer21);
//            realistic.getAnswerList().add(answer31);
//            realistic.getAnswerList().add(answer32);
//            realistic.getAnswerList().add(answer33);
//            realistic.getAnswerList().add(answer34);
//
//            intelligent.getAnswerList().add(answer1B);
//            intelligent.getAnswerList().add(answer6);
//            intelligent.getAnswerList().add(answer7);
//            intelligent.getAnswerList().add(answer8);
//            intelligent.getAnswerList().add(answer9);
//            intelligent.getAnswerList().add(answer16B);
//            intelligent.getAnswerList().add(answer20);
//            intelligent.getAnswerList().add(answer22);
//            intelligent.getAnswerList().add(answer23);
//            intelligent.getAnswerList().add(answer24);
//            intelligent.getAnswerList().add(answer31B);
//            intelligent.getAnswerList().add(answer35);
//            intelligent.getAnswerList().add(answer36);
//            intelligent.getAnswerList().add(answer37);
//
//            social.getAnswerList().add(answer2B);
//            social.getAnswerList().add(answer6B);
//            social.getAnswerList().add(answer10);
//            social.getAnswerList().add(answer11);
//            social.getAnswerList().add(answer12);
//            social.getAnswerList().add(answer17B);
//            social.getAnswerList().add(answer29B);
//            social.getAnswerList().add(answer25);
//            social.getAnswerList().add(answer26);
//            social.getAnswerList().add(answer27);
//            social.getAnswerList().add(answer36B);
//            social.getAnswerList().add(answer38);
//            social.getAnswerList().add(answer39);
//            social.getAnswerList().add(answer41B);
//            social.getAnswerList().add(answer26B);
//
//            conventional.getAnswerList().add(answer3B);
//            conventional.getAnswerList().add(answer7B);
//            conventional.getAnswerList().add(answer10B);
//            conventional.getAnswerList().add(answer13);
//            conventional.getAnswerList().add(answer14);
//            conventional.getAnswerList().add(answer18B);
//            conventional.getAnswerList().add(answer22B);
//            conventional.getAnswerList().add(answer25B);
//            conventional.getAnswerList().add(answer28);
//            conventional.getAnswerList().add(answer29);
//            conventional.getAnswerList().add(answer32B);
//            conventional.getAnswerList().add(answer38B);
//            conventional.getAnswerList().add(answer40);
//            conventional.getAnswerList().add(answer42);
//
//            enterprising.getAnswerList().add(answer4B);
//            enterprising.getAnswerList().add(answer8B);
//            enterprising.getAnswerList().add(answer11B);
//            enterprising.getAnswerList().add(answer13B);
//            enterprising.getAnswerList().add(answer15);
//            enterprising.getAnswerList().add(answer23B);
//            enterprising.getAnswerList().add(answer28B);
//            enterprising.getAnswerList().add(answer30);
//            enterprising.getAnswerList().add(answer33B);
//            enterprising.getAnswerList().add(answer35B);
//            enterprising.getAnswerList().add(answer37B);
//            enterprising.getAnswerList().add(answer39B);
//            enterprising.getAnswerList().add(answer40B);
//            enterprising.getAnswerList().add(answer20B);
//
//            artistic.getAnswerList().add(answer5B);
//            artistic.getAnswerList().add(answer9B);
//            artistic.getAnswerList().add(answer12B);
//            artistic.getAnswerList().add(answer14B);
//            artistic.getAnswerList().add(answer15B);
//            artistic.getAnswerList().add(answer19B);
//            artistic.getAnswerList().add(answer21B);
//            artistic.getAnswerList().add(answer24B);
//            artistic.getAnswerList().add(answer27B);
//            artistic.getAnswerList().add(answer29B);
//            artistic.getAnswerList().add(answer30B);
//            artistic.getAnswerList().add(answer34B);
//            artistic.getAnswerList().add(answer41);
//            artistic.getAnswerList().add(answer42B);
        };
    }
}
