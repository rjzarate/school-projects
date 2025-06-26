#include "scene_objects/agent/Agent.h"

Agent::Agent() {
    Sprite();
//		cout << "in Agent Constuctor" << endl;
}

void Agent::update() {
    //  Move and rotate sprite
    forward(1.0f);
    rotate(player->pos);

    // Add some forces to go towards player and integrate
    // Align path to the player
    glm::vec3 v = glm::normalize(player->pos - pos);
    glm::vec3 u = glm::vec3(0, -1, 0);
    float a = glm::orientedAngle(u, v, glm::vec3(0, 0, 1));
    float thrust = 100.0f; // TODO: thrust and damping for agents GUI
    force += glm::rotate(headingVector, a, glm::vec3(0, 0, 1)) * thrust;

    integrate();
}