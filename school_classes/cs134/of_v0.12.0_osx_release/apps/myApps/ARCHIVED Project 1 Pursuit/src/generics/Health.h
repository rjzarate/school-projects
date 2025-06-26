#pragma once

#include "ofMain.h"

class Health {
public:
    Health(float maxHealth, float health);
    float getHealth() { return health; }
    float getMaxHealth() { return maxHealth; }
    void setHealth(float health);
    void addHealth(float health);
    bool isDead() { return health <= 0.0f; }

private:
    float health, maxHealth;

};
