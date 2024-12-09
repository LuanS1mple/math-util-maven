/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.luans1mple.mathutil.core;

//import static la danh rieng cho nhung ham static
// goi truc tiep ma khong can class
import static com.luans1mple.mathutil.core.MathUtil.*;// đây là import tất cả static của class này
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author thanh
 */
public class MathUtilTest {
    public static Object[][] initData(){
        return new Integer[][] {{1,1},{2,2},{5,120},{6,720}};
    }
    @ParameterizedTest
   @MethodSource(value = "initData")
   public void testGetFactorialGivenRightRrturnWell(int input,long expected){
       assertEquals(expected, getFactorial(input));
   }
   @Test
   public void testGetFactorialGivenWrongThrowException(){
       //functional interface ten la Executable- co 1 ham duy nhat ten la excute()
       Executable exObject= new Executable() {
           @Override
           public void execute() throws Throwable {
               getFactorial(-6);
           }
       };
       assertThrows(IllegalArgumentException.class, exObject);
       //cach dung lambda
       //assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
   }
}
