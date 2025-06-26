#pragma once

// generics folder
#include "Health.h"

#include "ofMain.h"

class Ship {
public:
    float getHealth() { return health.getHealth(); }
    
    
private:
    Health health;
};
