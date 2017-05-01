package apps.oreonworlds.assets.plants;

import apps.oreonworlds.shaders.plants.TreeBillboardShader;
import apps.oreonworlds.shaders.plants.TreeBillboardShadowShader;
import apps.oreonworlds.shaders.plants.TreeLeavesShader;
import apps.oreonworlds.shaders.plants.TreeShadowShader;
import apps.oreonworlds.shaders.plants.TreeTrunkShader;
import engine.buffers.MeshVAO;
import engine.configs.AlphaTest;
import engine.configs.AlphaTestCullFaceDisable;
import engine.configs.Default;
import engine.geometry.Vertex;
import engine.math.Vec3f;
import engine.scenegraph.components.RenderInfo;
import engine.utils.Util;
import modules.instancing.InstancedDataObject;
import modules.instancing.InstancingObject;
import modules.modelLoader.obj.Model;
import modules.modelLoader.obj.OBJLoader;

public class Tree02ClusterGroup extends InstancingObject{
	
	public Tree02ClusterGroup(){
		
		Model[] models = new OBJLoader().load("./res/oreonworlds/assets/plants/Tree_02","tree02.obj","tree02.mtl");
		Model[] billboards = new OBJLoader().load("./res/oreonworlds/assets/plants/Tree_02","billboardmodel.obj","billboardmodel.mtl");
		
		for (Model model : models){
			
			InstancedDataObject object = new InstancedDataObject();
			MeshVAO meshBuffer = new MeshVAO();
			
			if (model.equals(models[0])){
				model.getMesh().setTangentSpace(true);
				Util.generateTangentsBitangents(model.getMesh());
			}
			else
				model.getMesh().setTangentSpace(false);
			model.getMesh().setInstanced(true);
			
			for (Vertex vertex : model.getMesh().getVertices()){
				vertex.getPos().setX(vertex.getPos().getX()*1.2f);
				vertex.getPos().setZ(vertex.getPos().getZ()*1.2f);
			}
			
			meshBuffer.addData(model.getMesh());

			if (model.equals(models[0]))
				object.setRenderInfo(new RenderInfo(new Default(), TreeTrunkShader.getInstance(), TreeShadowShader.getInstance()));
			else
				object.setRenderInfo(new RenderInfo(new AlphaTest(0.6f), TreeLeavesShader.getInstance(), TreeShadowShader.getInstance()));
				
			object.setMaterial(model.getMaterial());
			object.setVao(meshBuffer);
			getObjectData().add(object);
		}
		
		for (Model billboard : billboards){	
			InstancedDataObject object = new InstancedDataObject();
			MeshVAO meshBuffer = new MeshVAO();
			
			billboard.getMesh().setTangentSpace(false);
			billboard.getMesh().setInstanced(true);
			billboard.getMesh().setInstances(0);
			
			for (Vertex vertex : billboard.getMesh().getVertices()){
				vertex.setPos(vertex.getPos().mul(2.4f));
				vertex.getPos().setX(vertex.getPos().getX()*1f);
				vertex.getPos().setZ(vertex.getPos().getZ()*1f);
			}
			
			meshBuffer.addData(billboard.getMesh());
	
			object.setRenderInfo(new RenderInfo(new AlphaTestCullFaceDisable(0.4f), TreeBillboardShader.getInstance(), TreeBillboardShadowShader.getInstance()));
			
			object.setMaterial(billboard.getMaterial());
			object.setVao(meshBuffer);
			getObjectData().add(object);
		}
	
		addChild(new Tree02Cluster(2,new Vec3f(1363,0,-1179),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(599,0,-114),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(735,0,-187),getObjectData()));
		addChild(new Tree02Cluster(2,new Vec3f(1472,0,-1227),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(1614,0,-1270),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(1768,0,-1254),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(1737,0,-1161),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(1902,0,7),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(1780,0,301),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(92,0,1676),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(218,0,1671),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(315,0,1648),getObjectData()));
		addChild(new Tree02Cluster(3,new Vec3f(516,0,1306),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(474,0,1432),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(-43,0,1677),getObjectData()));
		addChild(new Tree02Cluster(3,new Vec3f(-167,0,1716),getObjectData()));
		addChild(new Tree02Cluster(6,new Vec3f(-482,0,1702),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(-657,0,1675),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(-1901,0,1100),getObjectData()));
		addChild(new Tree02Cluster(4,new Vec3f(-1834,0,140),getObjectData()));
	}
}
