
//--------------------------------------------------------------
//
//  Kevin M. Smith
//
//  Simple Octree Implementation 11/10/2020
// 
//  Copyright (c) by Kevin M. Smith
//  Copying or use without permission is prohibited by law.
//
#pragma once
#include "ofMain.h"
#include "generics/box.h"
#include "generics/ray.h"

// Multithreading
#include <thread>
#include <mutex>
#include <vector>
#include <functional>
#include <future>


class TreeNode { 
public:
	Box box;
	vector<int> points;
	vector<int> faces;
	vector<TreeNode> children;
};

class Octree {
public:
	
	void create(const ofMesh & mesh, int numLevels);
	void subdivide(const ofMesh & mesh, TreeNode & node, int numLevels, int level);
	bool intersect(const Ray &, const TreeNode & node, TreeNode & nodeRtn);
	bool intersect(const Box &, TreeNode & node, vector<Box> & boxListRtn);
	bool intersect(const Box &, TreeNode & node, vector<TreeNode*> & treeNodeListRtn);
	void draw(TreeNode & node, int numLevels, int level);
	void draw(int numLevels, int level);
	void drawLeafNodes(TreeNode & node);
	static void drawBox(const Box &box);
	static Box meshBounds(const ofMesh &);
	int getMeshPointsInBox(const ofMesh &mesh, const vector<int> & points, Box & box, vector<int> & pointsRtn);
	int getMeshFacesInBox(const ofMesh &mesh, const vector<int> & faces, Box & box, vector<int> & facesRtn);
	int getMeshFacesTouchingBox(const ofMesh &mesh, const vector<int> & faces, Box & box, vector<int> & facesRtn);
	void subDivideBox8(const Box &b, vector<Box> & boxList);

	ofMesh mesh;
	TreeNode root;
	bool bUseFaces = false;
	static vector<ofColor> colors;

	// debug;
	//
	int strayVerts= 0;
	int numLeaf = 0;
};