package web;


import document.*;
import javafx.util.Builder;
import org.springframework.web.bind.annotation.*;
import repo.CounterRepository;
import repo.ContextRepository;
import repo.IdentifierRepository;
import repo.RewardRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @Resource
    public CounterRepository counterRepository;

    @Resource
    public ContextRepository contextRepository;

    @Resource
    public RewardRepository rewardRepository;

    @Resource
    public IdentifierRepository identifierRepository;

    @GetMapping(value = "/_inject")
    public void inject(@RequestParam(value="quantity", required = true) int quantity) {


        for (int i = 0; i < quantity; i++){
            Counter counter = Counter.builder().buId(1L).value(100.0).counterType("P").build();
            counterRepository.save(counter);
            System.out.println("Commit counter P : "+ counter);

            Counter counter2 = Counter.builder().buId(1L).value(10000.0).counterType("E").build();
            counterRepository.save(counter2);
            System.out.println("Commit counter E : "+ counter2);

            Counter counter3 = Counter.builder().buId(1L).value(150000.).counterType("G").build();
            counterRepository.save(counter3);
            System.out.println("Commit counter G : "+ counter3);

            List<Counter> counters = new ArrayList<>();
            counters.add(counter);
            counters.add(counter2);
            counters.add(counter3);

            Reward reward = Reward.builder().buId(1L).rewardType("REWARD1").build();
            rewardRepository.save(reward);
            System.out.println("Commit reward : "+ reward);

            Reward reward2 = Reward.builder().buId(1L).rewardType("REWARD2").build();
            rewardRepository.save(reward2);
            System.out.println("Commit reward : "+ reward2);

            Reward reward3 = Reward.builder().buId(1L).rewardType("REWARD3").build();
            rewardRepository.save(reward3);
            System.out.println("Commit reward : "+ reward3);


            List<Reward> rewards = new ArrayList<>();
            rewards.add(reward);
            rewards.add(reward2);
            rewards.add(reward3);

            Context context = Context.builder().counters(counters).rewards(rewards).build();
            System.out.println("Commit context : "+ context);
            contextRepository.save(context);

            Identifier identifier = Identifier.builder().context(context).type("CUSTOMER").value(UUID.randomUUID().toString()).build();
            identifierRepository.save(identifier);
            System.out.println("Commit identifier CUSTOMER : "+ identifier);

            Identifier identifier2 = Identifier.builder().context(context).type("ACCOUNT").value(UUID.randomUUID().toString()).build();
            identifierRepository.save(identifier2);
            System.out.println("Commit identifier ACCOUNT : "+ identifier2);

            counter.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            counter.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            counterRepository.save(counter);

            counter2.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            counter2.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            counterRepository.save(counter2);

            counter3.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            counter3.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            counterRepository.save(counter3);


            reward.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            reward.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            rewardRepository.save(reward);

            reward2.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            reward2.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            rewardRepository.save(reward2);

            reward3.getIdentifiers().add(ContextIdentifier.builder().type(identifier.getType()).value(identifier.getValue()).build());
            reward3.getIdentifiers().add(ContextIdentifier.builder().type(identifier2.getType()).value(identifier2.getValue()).build());
            rewardRepository.save(reward3);

        }



    }


    @GetMapping(value="/counters")
    public List<Counter> getCounters(@RequestParam(value="identifierType", required = true) String identifierType,
                                     @RequestParam(value="identifierValue", required = true) String identifierValue,
                                     @RequestParam(name="counterType", required = false) String counterType){
        Identifier id = identifierRepository.findByTypeAndValue(identifierType,identifierValue);

        return id.getContext().getCounters();
    }

    @GetMapping(value="/rewards")
    public List<Reward> getRewards(@RequestParam(value="identifierType", required = true) String identifierType,
                                     @RequestParam(value="identifierValue", required = true) String identifierValue){
        Identifier id = identifierRepository.findByTypeAndValue(identifierType,identifierValue);

        return id.getContext().getRewards();
    }


}
