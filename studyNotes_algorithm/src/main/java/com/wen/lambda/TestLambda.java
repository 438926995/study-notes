package com.wen.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author huwenwen
 * @since 16/9/3
 */
public class TestLambda {

  public static List<Person> personsList() {
    List<Person> persons = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      Person p = new Person(i + "儿子", 8 - i);
      persons.add(p);
    }
    return persons;
  }

  public static void main(String[] args) {
    List<Person> persons = personsList();
    List<Person> collect =
        persons.stream().filter(p -> p.getAge() > 6).collect(Collectors.toList());
    System.out.println(persons.size() + "," + collect.size());
    DoubleSupplier doubleSupplier = () -> 5;
    System.out.println(doubleSupplier.getAsDouble());

    persons.forEach(p -> System.out.println(p.getName()));

    // persons -> map
    Map<Integer, Person> collect1 =
        persons.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));

  }
}
