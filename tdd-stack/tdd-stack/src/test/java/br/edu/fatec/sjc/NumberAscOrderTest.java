package br.edu.fatec.sjc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @SuppressWarnings("rawtypes")
    @Mock
    private NumberAscOrder numberAscOrder;
    @Mock
    private CustomStack<Double> customStack;
    @Mock
    private CalculableStrategy<Double> calculableStrategy;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @BeforeEach
    public void setUp() {
        numberAscOrder = new NumberAscOrder(customStack);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSortWithSixRandomNumbers() throws StackEmptyException, StackFullException {

        List<Double> randomNumbers = new ArrayList<>();

        // Gerando uma lista com 6 números aleatórios
        for (int i = 0; i < 6; i++) {
            double randomNumber = new Random().nextDouble();
            randomNumbers.add(randomNumber);
        }

        // Mockando o comportamento da pilha
        Mockito.when(customStack.getElements()).thenReturn(randomNumbers);
        Mockito.when(customStack.size()).thenReturn(6);

        // Obtendo a lista ordenada usando o método sort()
        List<Double> sortedList = numberAscOrder.sort();

        // Verificando se a lista ordenada é igual à lista de números inseridos ordenada
        List<Double> originalList = new ArrayList<>(randomNumbers);
        originalList.sort(Double::compareTo);

        Assertions.assertEquals(originalList, sortedList);

    }

    @Test
    public void testSortWithEmptyList() throws StackEmptyException, StackFullException {


    }

}
