package de.hpi.pictureSupport;

import java.util.ArrayList;
import java.util.UUID;

import org.oryxeditor.server.diagram.Bounds;
import org.oryxeditor.server.diagram.Point;
import org.oryxeditor.server.diagram.Shape;
import org.oryxeditor.server.diagram.StencilType;
import org.xmappr.Attribute;
import org.xmappr.RootElement;

/**
 * The Class PictureBuildingBlockOccurrence.
 */
@RootElement("buildingBlockOccurrence")
public class PictureBuildingBlockOccurrence {

	/** The is twin. */
	@Attribute(name="twin")
	private Boolean isTwin;
	
	/** The building block. */
	@Attribute
	private int buildingBlock;

	/**
	 * Gets the checks if is twin.
	 *
	 * @return the checks if is twin
	 */
	public Boolean getIsTwin() {
		return isTwin;
	}

	/**
	 * Sets the checks if is twin.
	 *
	 * @param isTwin the new checks if is twin
	 */
	public void setIsTwin(Boolean isTwin) {
		this.isTwin = isTwin;
	}

	/**
	 * Gets the building block.
	 *
	 * @return the building block
	 */
	public int getBuildingBlock() {
		return buildingBlock;
	}

	/**
	 * Sets the building block.
	 *
	 * @param buildingBlock the new building block
	 */
	public void setBuildingBlock(int buildingBlock) {
		this.buildingBlock = buildingBlock;
	}

	public Shape createBlockFor(Shape process, ArrayList<Shape> processChildren) {

		// TODO get the block type from block repository
		String blockTypeId = "createnewdocument";
		Shape block = new Shape(String.valueOf(UUID.randomUUID()), new StencilType(blockTypeId));
		Bounds bounds = calculateBounds(processChildren);
		block.setBounds(bounds);
		return block;
	}

	private Bounds calculateBounds(ArrayList<Shape> processChildren) {
		
		Point lowerRight = new Point(600.0, 110.0);
		Point upperLeft = new Point(0.0,50.0);
		if (!processChildren.isEmpty()) {
			lowerRight.setY(processChildren.get(processChildren.size()-1).getLowerRight().getY() + 80.0);
			upperLeft.setY(processChildren.get(processChildren.size()-1).getUpperLeft().getY() + 80.0);
		}
		Bounds bounds = new Bounds(lowerRight, upperLeft);
		return bounds;
	}
}
