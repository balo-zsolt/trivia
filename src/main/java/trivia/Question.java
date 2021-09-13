package trivia;

import java.util.*;

public class Question {

	private static final int FIRST = 0;
	private static final String POP_QUESTION = "Pop Question ";
	private static final String SCIENCE_QUESTION = "Science Question ";
	private static final String SPORTS_QUESTION = "Sports Question ";
	private static final String ROCK_QUESTION = "Rock Question ";

	private final Map<QuestionCategory, List<String>> questionMap = new EnumMap<>(QuestionCategory.class);

	public Question() {
		initQuestions();
	}

	private void initQuestions() {

		Arrays.stream(QuestionCategory.values())
				.forEachOrdered(category -> questionMap.put(category, new LinkedList<>()));

		for (int i = 0; i < 50; i++) {
			questionMap.get(QuestionCategory.POP).add(POP_QUESTION + i);
			questionMap.get(QuestionCategory.ROCK).add(ROCK_QUESTION + i);
			questionMap.get(QuestionCategory.SCIENCE).add(SCIENCE_QUESTION + i);
			questionMap.get(QuestionCategory.SPORTS).add(SPORTS_QUESTION + i);
		}
	}

	public String askQuestion(final QuestionCategory questionCategory) {
		return questionMap.get(questionCategory).remove(FIRST);
	}

	public QuestionCategory currentCategory(final int place) {
		switch (place % 4) {
		case 0: return QuestionCategory.POP;
		case 1: return QuestionCategory.SCIENCE;
		case 2: return QuestionCategory.SPORTS;
		default: return QuestionCategory.ROCK;
		}
	}
}
