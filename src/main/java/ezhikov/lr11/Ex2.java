package ezhikov.lr11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path pathToData = Path.of("src/main/java/ezhikov/lr11/data.json").toAbsolutePath();
        List<Person> people = mapper.readValue(
                pathToData.toFile(),
                mapper.getTypeFactory().constructCollectionType(List.class, Person.class)
        );
        System.out.println(people.size());

        // Задание 2.1
        // 1. filter: фильтруем по зарплате выше 50000
        List<Person> highEarners = people.stream()
                .filter(person -> person.salary() > 50_000)
                .toList();
        System.out.println(highEarners);

        // 2. sorted: Сортировка по возрасту
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::age))
                .toList();
        System.out.println(sortedByAge);

        // 3. limit: Ограничиваем количество выводимых объектов
        List<Person> firstFive = people.stream()
                .limit(5)
                .toList();
        System.out.println(firstFive);

        // 4. map: трансформируем объект в строку с работой
        List<String> jobTitles = people.stream()
                .map(Person::job)
                .toList();
        System.out.println(jobTitles);

        // Задание 2.2
        // 2.2.1
        List<Person> top10SalariesUnder25InPragueCity = people.stream()
                .filter(person -> person.age() < 25 && person.city().equals("Прага"))
                .sorted(Comparator.comparingInt(Person::salary).reversed())
                .limit(10)
                .toList();
        System.out.println(top10SalariesUnder25InPragueCity);

        // 2.2.2
        long countHighEarningDrivers = people.stream()
                .filter(person -> person.salary() > 50_000 && person.job().equals("Водитель"))
                .count();
        System.out.println(countHighEarningDrivers);

        // 2.2.3
        OptionalInt maxSalary = people.stream()
                .filter(person -> person.city().equals("Прага"))
                .filter(person -> person.age() >= 30 && person.age() <= 40)
                .mapToInt(Person::salary)
                .max();
        System.out.println(maxSalary);

        // 2.2.4
        OptionalInt minAge = people.stream()
                .filter(person -> person.city().equals("Прага"))
                .filter(person -> person.salary() > 100_000)
                .mapToInt(Person::age)
                .min();
        System.out.println(minAge);

        // Задание 2.3
        // 2.3.1 сгруппируем по работе
        Map<String, List<Person>> peopleByJob = people.stream()
                .collect(Collectors.groupingBy(Person::job));
        System.out.println(peopleByJob);

        // 2.3.2
        Map<String, Long> countByCity = people.stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.counting()));
        System.out.println(countByCity);

        // 2.3.3
        Map<String, Optional<Person>> maxSalaryByCity = people.stream()
                .collect(Collectors.groupingBy(Person::city,
                        Collectors.maxBy(Comparator.comparingInt(Person::salary))));
        System.out.println(maxSalaryByCity);

        // 2.3.4
        Map<String, Map<String, Double>> avgSalaryByCityAndJob = people.stream()
                .collect(Collectors.groupingBy(Person::city,
                        Collectors.groupingBy(Person::job, Collectors.averagingInt(Person::salary))));
        System.out.println(avgSalaryByCityAndJob);
    }
}
