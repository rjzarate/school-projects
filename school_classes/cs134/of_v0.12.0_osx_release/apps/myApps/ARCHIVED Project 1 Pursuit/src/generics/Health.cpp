#include "Health.h"

Health::Health(float maxHealth, float health) {
    this->health = health;
    this->maxHealth = maxHealth;
    
    if (maxHealth < health) {
        cout << "Warning: health is greater than max health." << endl;
    }
}

void Health::setHealth(float health) {
    this->health = health;
    
    if (maxHealth < health) {
        cout << "Warning: health is greater than max health." << endl;
    }
}

void Health::addHealth(float health) {
    this->health += health;
    
    if (maxHealth < health) {
        cout << "Warning: health is greater than max health." << endl;
    }
}


