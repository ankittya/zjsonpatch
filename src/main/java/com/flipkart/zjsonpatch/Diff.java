package com.flipkart.zjsonpatch;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * User: gopi.vishwakarma
 * Date: 30/07/14
 */
class Diff {
    private final Operation operation;
    private final List<Object> path;
    private final JsonNode value;
    private JsonNode oldValue;
    private List<Object> toPath; //only to be used in move operation

    Diff(Operation operation, List<Object> path, JsonNode value) {
        this.operation = operation;
        this.path = path;
        this.value = value;
    }

    Diff(Operation operation, List<Object> fromPath, JsonNode value, List<Object> toPath) {
        this.operation = operation;
        this.path = fromPath;
        this.value = value;
        this.toPath = toPath;
    }

    public Diff(Operation operation, List<Object> path, JsonNode value, JsonNode oldValue) {
         this.operation = operation;
         this.path = path;
         this.value = value;
         this.oldValue = oldValue;
	}

	public Operation getOperation() {
        return operation;
    }

    public List<Object> getPath() {
        return path;
    }

    public JsonNode getValue() {
        return value;
    }

    public static Diff generateDiff(Operation replace, List<Object> path, JsonNode target) {
        return new Diff(replace, path, target);
    }

    List<Object> getToPath() {
        return toPath;
    }

	public static Diff generateDiff(Operation replace, List<Object> path, JsonNode target, JsonNode source) {
		return new Diff(replace, path, target, source);
	}

	public JsonNode getOldValue() {
		return oldValue;
	}

	public void setOldValue(JsonNode oldValue) {
		this.oldValue = oldValue;
	}
}
