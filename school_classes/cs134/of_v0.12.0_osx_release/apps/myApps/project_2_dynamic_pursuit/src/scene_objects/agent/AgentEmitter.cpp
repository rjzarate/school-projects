#include "scene_objects/agent/AgentEmitter.h"

void AgentEmitter::spawnSprite() {   
    // random
    std::random_device randomDevice;
    std::mt19937 gen(randomDevice());
    std::uniform_int_distribution<> rng(0, 0);

    // Move to a random position on the edges of the screen
    rng = std::uniform_int_distribution<>(0, 3);
    switch (rng(gen)) {
        case 0:
            rng = std::uniform_int_distribution<>(0, ofGetWindowWidth());
            pos = glm::vec3(rng(gen), -30, 0);
            break;
        case 1:
            rng = std::uniform_int_distribution<>(0, ofGetWindowHeight());
            pos = glm::vec3(-30, rng(gen), -30);
            break;
        case 2:
            rng = std::uniform_int_distribution<>(0, ofGetWindowWidth());
            pos = glm::vec3(rng(gen), ofGetWindowHeight() + 30, 0);
            break;
        case 3:
            rng = std::uniform_int_distribution<>(0, ofGetWindowHeight());
            pos = glm::vec3(ofGetWindowWidth() + 30, rng(gen), 0);
            break;
    }
    
    // Get random position on the screen
    rng = std::uniform_int_distribution<>(0, ofGetWindowWidth());
    float x = rng(gen);
    rng = std::uniform_int_distribution<>(0, ofGetWindowHeight());
    float y = rng(gen);
    glm::vec3 randomPosition = glm::vec3(x, y, 0);
    
    
    
    
//		cout << "in AgentEmitter::spawnSprite" << endl;
    Agent sprite;
    if (haveChildImage) sprite.setImage(childImage);
    sprite.color = ofColor::green;
    sprite.lifespan = lifespan;
    sprite.pos = pos;
    sprite.forwardSpeed = childSpeed;
    sprite.birthtime = ofGetElapsedTimeMillis();
    
//        // Align path of travel to velocity
//        //
//        glm::vec3 v = glm::normalize(sprite.velocity);
//        glm::vec3 u = glm::vec3(0, -1, 0);
//        float a = glm::orientedAngle(u, v, glm::vec3(0, 0, 1));
//        sprite.rot =  glm::degrees(a);
    
    // Align path to the direction
    glm::vec3 v = glm::normalize(randomPosition - pos);
    glm::vec3 u = glm::vec3(0, -1, 0);
    float a = glm::orientedAngle(u, v, glm::vec3(0, 0, 1));
    sprite.rotation = glm::degrees(a);

    // Get and set player
    sprite.player = this->player;

    sys->add(make_unique<Agent>(std::move(sprite)));
    lastSpawned = ofGetElapsedTimeMillis();
}