package org.agmas.client.duck;

public interface AvatarAccessor {

    void setStartedLeaningAge(float age);
    float getStartedLeaningAge();

    void setPreviousLeaning(int previousLeaning);
    int getPreviousLeaning();
}
