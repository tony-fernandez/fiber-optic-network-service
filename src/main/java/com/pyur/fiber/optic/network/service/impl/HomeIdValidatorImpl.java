package com.pyur.fiber.optic.network.service.impl;

import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringUtils.isBlank;

import com.pyur.fiber.optic.network.exception.InvalidHomeIdFormatException;
import com.pyur.fiber.optic.network.service.HomeIdValidator;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HomeIdValidatorImpl implements HomeIdValidator {

  private static final Pattern PATTERN = compile("^X[A-Z0-9]{7}$");

  @Override
  public void validate(String homeId) {
    if (isBlank(homeId) || !PATTERN.matcher(homeId).matches()) {
      throw new InvalidHomeIdFormatException();
    }
    validateCheckDigit(homeId);
  }

  private void validateCheckDigit(String homeId) {
    char[] characters = homeId.toCharArray();
    int checkDigit = Character.getNumericValue(characters[7]);
    int sum = 0;

    for (int i = 0; i < characters.length - 1; i++) {
      char c = characters[i];
      int value = Character.getNumericValue(c);

      if (i % 2 != 0) {
        value = value * 3;
      }

      sum += value;
    }

    if (sum % 36 != checkDigit) {
      throw new InvalidHomeIdFormatException();
    }
  }
}
