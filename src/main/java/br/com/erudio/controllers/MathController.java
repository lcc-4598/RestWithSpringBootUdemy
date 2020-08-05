package br.com.erudio.controllers;

import br.com.erudio.validation.MathValidator;
import br.com.erudio.exception.UnsupportedMathOpperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    MathValidator mt = new MathValidator();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!mt.isNumeric(numberOne) || !mt.isNumeric(numberTwo)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value");
        }
        Double sum = mt.convertToDouble(numberOne) + mt.convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!mt.isNumeric(numberOne) || !mt.isNumeric(numberTwo)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value");
        }
        Double sub = mt.convertToDouble(numberOne) - mt.convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!mt.isNumeric(numberOne) || !mt.isNumeric(numberTwo)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value");
        }
        Double mult = mt.convertToDouble(numberOne) * mt.convertToDouble(numberTwo);
        return mult;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!mt.isNumeric(numberOne) || !mt.isNumeric(numberTwo) || !mt.isNotZero(numberTwo)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value, denominator also must not be zero");
        }
        Double div = mt.convertToDouble(numberOne) / mt.convertToDouble(numberTwo);
        return div;
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!mt.isNumeric(numberOne) || !mt.isNumeric(numberTwo)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value");
        }
        Double avg = (mt.convertToDouble(numberOne) + mt.convertToDouble(numberTwo)) / 2;
        return avg;
    }

    @RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
    private Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!mt.isNumeric(numberOne)) {
            throw new UnsupportedMathOpperationException("Please set a numeric value");
        }
        Double sqrt = Math.sqrt(mt.convertToDouble(numberOne));
        return sqrt;
    }


}
