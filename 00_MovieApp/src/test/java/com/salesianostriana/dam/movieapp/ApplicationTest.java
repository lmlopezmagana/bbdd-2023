
package com.salesianostriana.dam.movieapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Application")
public class ApplicationTest {

  @Test
  @DisplayName("Pointless test")
  void smokeTest() {
    assertThat(true).isEqualTo(true);
  }
}
