package io.crowdcode.speedbay.auction.validator;

import io.crowdcode.speedbay.auction.exception.BadWordException;
import io.crowdcode.speedbay.auction.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SU00079 on 29.09.2016.
 */
@Slf4j
@Component
public class BadWordValidatorBean implements BadWordValidator {

    @Value("classpath:badWords.txt")
    private Resource badWordsFile;

    private List<String> badWords;

    @PostConstruct
    private void init() {
        try (InputStream is = badWordsFile.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader bufferedReader = new BufferedReader(isr)) {

            badWords = bufferedReader.lines().map(line -> line.split("\\,\\s?"))
                    .distinct().flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            log.info("found bad words: {}", Arrays.toString(badWords.toArray()));

        } catch (IOException e) {
            throw new SystemException("Could not read BadWords", e);
        }
    }

    @Override
    public void checkBadWords(String title) throws BadWordException {
        if (isInvalid(title)) {
            throw new BadWordException(title);
        }
    }

    @Override
    public boolean isInvalid(String title) {
        if (title != null && badWords != null) {
            for (String badWord : badWords) {
                if (title.contains(badWord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
