public class GenericFeedback<T> {
    private T feedback;

    public GenericFeedback(T feedback) {
        this.feedback = feedback;
    }

    public T getFeedback() {
        return feedback;
    }

    public void setFeedback(T feedback) {
        this.feedback = feedback;
    }
}

