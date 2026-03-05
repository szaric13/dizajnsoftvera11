package raf.draft.dsw.model.composite;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.observer.IPublisher;

@Getter
@Setter
public abstract class DraftNode implements IPublisher {
        private String name;
        private transient DraftNode parent;

        public DraftNode(String name, DraftNode parent) {
                this.name = (name != null) ? name : "Unnamed";
                this.parent = parent;
        }
        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                DraftNode other = (DraftNode) obj;
                if (this.getName() != null && this.getName().equals(other.getName())) {
                        if (this.getParent() == null && other.getParent() == null) {
                                return true;
                        }
                        return this.getParent() != null && this.getParent().equals(other.getParent());
                }
                return false;
        }

        /*public boolean equals(Object o) {
                if(!(o instanceof DraftNode))return false;
                DraftNode newObject = (DraftNode) o;
                return this.getName().equals(newObject.getName());
        }
*/
       /* public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                }
                if (obj == null || !(obj instanceof DraftNode)) {
                        return false;
                }

                DraftNode otherObj = (DraftNode) obj;
                return this.name != null && this.name.equals(otherObj.getName());
        }*/

}
