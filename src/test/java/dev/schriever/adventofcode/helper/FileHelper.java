package dev.schriever.adventofcode.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RequiredArgsConstructor
public class FileHelper {

  private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

  public static List<String> readAllLines(String location) throws IOException {
    Resource inputFile = RESOURCE_LOADER.getResource(location);
    return Files.readAllLines(inputFile.getFile().toPath());
  }

}
